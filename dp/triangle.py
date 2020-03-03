def solution(triangle):
	answer = 0
	h = len(triangle)
	triangle.reverse()

	B = [[0]*(h-1) for i in range(h-1)]

	for i in range(h):
		if i == 0 :
			for j in range(h-i-1):
				left = triangle[i][j] + triangle[i+1][j]
				right = triangle[i][j+1] + triangle[i+1][j]
				B[i][j] = max(left,right)
		else :
			for j in range(h-i-1):
				left =	B[i-1][j] + triangle[i+1][j]
				right = B[i-1][j+1] + triangle[i+1][j]
				B[i][j] = max(left,right)
	
	return B[h-2][0]
	


b = [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]

a = solution(b)
print (a)
