def dfs(map,visited,size) :
	stack = []
	home_list = []
	for x in range(size) :
		for y in range(size) :
			#최초 단지 발견
			if map[x][y] == 1 and visited[x][y] == False :
				visited[x][y] = True
				count = 1
				stack.append((x,y))
				while True :
					if stack == [] :
						home_list.append(count)
						break
					else :
						cur_node = stack.pop()
						path = [(cur_node[0]+1,cur_node[1])
								,(cur_node[0]-1,cur_node[1])
								,(cur_node[0],cur_node[1]+1)
								,(cur_node[0],cur_node[1]-1)]
						# print(path)
						# print(map)
						for x1,y1 in path :
							if 0<= x1 <= size-1 and 0<= y1 <= size-1 and map[x1][y1] == 1 and visited[x1][y1] == False :
								stack.append((x1,y1))
								# print(x1,y1)
								# print(map[x1][y1])
								# print(count)
								visited[x1][y1] = True
								count += 1

	return home_list
				






if __name__ == "__main__":
	size = int(input())
	map = [[0]*size for i in range(size)]
	visited = [[False]*size for i in range(size)]
	
	for row in range(size) :
		line = input()
		for col in range(size) :
			map[row][col] = int(line[col])

	l = dfs(map,visited,size)
	l.sort()
	print(len(l))
	for i in l :
		print(i)
	

	'''
7
0110100
0110101
1110101
0100111
0100000
0111110
0111000
'''