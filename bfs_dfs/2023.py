import math

def primeCheck(num):
	prime = math.sqrt(num)
	for i in range(2,int(prime)) :
		if num%i == 0:
			return False
	return True


def sol(N):
	stack = []
	for num in range(pow(10,N-1),pow(10,N)) :
		if primeCheck(num) :
			stack.append(num)
	print(stack)


if __name__ == "__main__" :
	N = int(input())
	sol(N)

