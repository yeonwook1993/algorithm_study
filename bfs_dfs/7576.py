from collections import deque

def dfs(box,visited,row,col) :
	queue = deque()
	for x in range(row) :
		for y in range(col) :
			if box[x][y]  == 1 :
				visited[x][y] = True
				queue.append((x,y,0))

			elif box[x][y] == -1 :
				visited[x][y] = True
	height = 0
	if queue == [] :
		print(-1)
	else :
		while queue :
			cur_node = queue.popleft()
			path = [(cur_node[0]+1,cur_node[1],cur_node[2]+1)
					,(cur_node[0]-1,cur_node[1],cur_node[2]+1)
					,(	cur_node[0],cur_node[1]+1,cur_node[2]+1)
					,(cur_node[0],cur_node[1]-1,cur_node[2]+1)]
			for x1,y1,height in path :
				if 0 <= x1 <= row-1 and 0 <= y1 <= col-1 and visited[x1][y1] == False and box[x1][y1] != -1 :
					visited[x1][y1] = True
					queue.append((x1,y1,height))
			height = cur_node[2]
		
		for i in visited :
				if False in i :
					print(-1)
					break
				else :
					print(height)
					break




if __name__ == "__main__":
	col,row = map(int, input().split())
	box = []
	visited = [[False] * int(col) for _ in range(int(row))]
	for i in range(int(row)) :
		buf = list(map(int,input().split()))
		box.append(buf)
	dfs(box,visited,int(row),int(col))



