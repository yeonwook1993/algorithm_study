#다른이 풀이
def solution(N):
    dp = [0] * int(N+2)			#몰랐떤 방법 <- 잘 기억해 두기   2차원으로 하고싶다면 [[0]]
    if N == 1: return 4
    if N == 2: return 6
    dp[0], dp[1], dp[2] = 0, 1, 1
    for i in range(3, N+2):
        dp[i] = dp[i-1] + dp[i-2]
    return 2*dp[N-1] + 4*dp[N]


#내풀이
def solution(N):
    answer = 1
    answer2 = 1
    if N == 1 :
        return 4
    elif N == 2 :
        return 6
    else :
        for i in range(N-2) :
            answer2,answer = answer, answer2+answer
        return ((answer+answer2)+answer)*2



'''
	주의 할점 :
	다른 사람의 풀이처럼
	이전의 결과값들을 보유하고 있는 것이 좋다.
	나의 경우는 문제 예시에 따르면 필요가 없어서 날려버렸지만
	그 값들을 그대로 보전하여 보관하다가 필요시 언제든 꺼낼수 있도록 하는 것이 좋은 방법 이다.

'''