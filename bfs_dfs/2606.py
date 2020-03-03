def dfs(pair_list, visited) :
	stack = [1]
	visited[1] = True
	count = 0

	while True :
		if stack == [] :
			print(count)
			break
		cur_node = stack.pop()
		for route in pair_list :
			if route[0] == cur_node and visited[route[1]] == False :
				stack.append(route[1])
				count += 1
				visited[route[1]] = True




if __name__ == "__main__":
	com_count = int(input())
	visited = [False] * (com_count+1)
	pair_list = []
	network = int(input())

	for _ in range(network) :
		a,b = input().strip().split()
		t = [int(a),int(b)]
		t2 = [int(b),int(a)]
		pair_list.append(t)
		pair_list.append(t2)

	
	dfs(pair_list, visited)