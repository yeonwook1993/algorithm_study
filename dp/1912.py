# 시간 초과난 방법
# 2중 포문을 해결할 방법을 찾자

# def dp(n,l) :
# 	max_val = -1000

# 	for i in range(n) :
# 		for j in range(n-i) :
# 			cont_sum = sum(l[j:i+j+1])
# 			max_val = max(cont_sum,max_val)

# 	print(max_val)

# if __name__ =="__main__" :
# 	n = int(input())
# 	l = list(map(int,input().split()))
# 	dp(n,l)



def dp(n,l) :
	dp = [0] * n
	dp[0] = l[0]

	for index in range(1,n) :
		dp[index] = max(dp[index-1] + l[index],l[index])
	print(max(dp))

if __name__ =="__main__" :
	n = int(input())
	l = list(map(int,input().split()))
	dp(n,l)