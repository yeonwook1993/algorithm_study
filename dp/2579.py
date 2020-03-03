def dp(stair,count) :
	dp = [0] * (count + 1)
	dp[1] = stair[1]
	dp[2] = stair[1] + stair[2]
	dp[3] = max(stair[1]+stair[3],stair[2]+stair[3])

	for i in range(4,count+1) :
		dp[i] = max(dp[i-2] + stair[i],dp[i-3]+stair[i]+stair[i-1])

	print(dp[i])

if __name__ == "__main__" :
	count = int(input())
	stair = []
	stair.append(0)
	for _ in range(count) :
		stair.append(int(input()))
	dp(stair,count)

'''

n번째 계단을 오르게 되는 경우는 두가지가 있다.
	1. 이전 계단을 밞고 오게되는 경우
	2. 두칸을 뛰어넘고 오는 경우

	1번의 경우 연속해서 계단을 밟은 상황이면 안되기 때문에 i의 전전 계단인 i-3 까지의 최대값과 현재계단, 이전 계단의 합
	2번의 경우 두칸을 뛰어 넘고 왔기 떄문에 i-2까지의 최대값 + 현재계단의 합이 되며,
	이중 큰 값을 i 번쨰에 저장.

'''

