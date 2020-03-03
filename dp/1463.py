def dp(num) :
	if num <= 3 :
		if num == 1 :
			print(0)
		else :
			print(1)
	else :
		dp = [1] * (num+1)
		dp[1] = 0
		dp[2] = 1
		dp[3] = 1

		for i in range(4,num+1) :
			if i%6 == 0 :
				dp[i] = min(dp[i//3],dp[i//2],dp[i-1]) + 1
			elif i%3 == 0 :
				dp[i] = min(dp[i-1], dp[i//3]) + 1
			elif i%2 == 0 : 
				dp[i] = min(dp[i-1], dp[i//2]) + 1
			else :
				dp[i] = dp[i-1] + 1
		print(dp[num])

if __name__ == "__main__" :
	num = int(input())
	dp(num)

