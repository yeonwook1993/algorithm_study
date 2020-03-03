def bfs(row,col,ocean,queue) :
	visited = [[False] * col for _ in range(row)]
	best_h = 0
	while queue != [] :
		x,y,h = queue.pop(0)
		visited[x][y] = True
		path = [(x+1,y), (x-1,y), (x,y+1), (x,y-1)]
		for x1,y1 in path :
			if 0<= x1 < row and 0 <= y1 < col and visited[x1][y1] is False and ocean[x1][y1] == 'L':
				visited[x1][y1] = True
				queue.append((x1,y1,h+1))
		best_h = max(best_h,h)
	return best_h


if __name__ == "__main__":
	row,col = map(int,input().split())
	ocean = [list(input().strip())  for _ in range(row)]
	cur_height = 0
	for x in range(row) :
		for y in range(col) :
			if ocean[x][y] == "L" :
				queue = [(x,y,0)]
				cur_height = max(cur_height,bfs(row,col,ocean,queue))
	print(cur_height)

# from collections import deque
# from sys import stdin
# input = stdin.readline

# n, m = map(int, input().split())
# a = [list(input().strip()) for _ in range(n)]
# check = [[False]*m for _ in range(n)]
# dx = (-1, 0, 1, 0)
# dy = (0, 1, 0, -1)

# def bfs(i, j):
# 	q = deque()
# 	q.append((i, j, 0))
# 	check[i][j] = True
# 	dist = 0
# 	while q:
# 		x, y, d = q.popleft()
# 		for k in range(4):
# 			nx, ny = x+dx[k], y+dy[k]
# 			if nx < 0 or nx >= n or ny < 0 or ny >= m:
# 				continue
# 			if check[nx][ny] is False and a[nx][ny] == 'L':
# 				q.append((nx, ny, d+1))
# 				check[nx][ny] = True
# 				dist = max(dist, d+1)
# 	return dist

# ans = 0
# for i in range(n):
# 	for j in range(m):
# 		if a[i][j] == 'L':
# 			check = [[False]*m for _ in range(n)]
# 			ans = max(ans, bfs(i, j))
# print(ans) 


