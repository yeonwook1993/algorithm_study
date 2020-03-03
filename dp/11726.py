def dp(n) :
	n1 = 1
	n2 = 2

	for i in range(3,n+1) :
		n1,n2 = n2,n1+n2
	print(n2%10007)

if __name__ == "__main__" :
	N = int(input())
	if N == 1 :
		print(1)
	elif N == 2 :
		print(2)
	else :
		dp(N)

'''
dp[i] = dp[i-1] + dp[i-2]

i-1 단계에 1을 넣는 경우 + i-2 단계에 2를 넣는 경우가 다음 단계 i의 case가 된다.
1

1 1
2

1 1 1
1 2
2 1

1 1 1 1
1 2 1
1 1 2
2 1 1
2 2

1 1 1 1 1
1 1 1 2
1 2 1 1
2 1 1 1
1 1 2 1
1 2 2
2 1 2
2 2 1


1 2 3 5 8 13 21 34 
'''