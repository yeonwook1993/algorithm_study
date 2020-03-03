def dp(numList) :
	maxnum = max(numList)
	dp = [0] * (maxnum + 1)
	dp[1] = 1
	dp[2] = 2
	dp[3] = 4
	for i in range(4,maxnum+1) :
		dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
	for index in numList :
		print(dp[index])


if __name__ == "__main__" :
	how = int(input())
	numList = []
	for _ in range(how) :
		numList.append(int(input()))
	dp(numList)
