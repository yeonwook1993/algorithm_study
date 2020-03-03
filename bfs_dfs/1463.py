def dp(num) :
	array = [0] * (num+1)
	array[1] = 1
	array[2] = 1
	array[3] = 1

	for i in range(4,i+1) :
		if i%3 == 0 :
			array[i] = min(array[i-1] + 1 ,array[i//3] + 1)
		elif i%2 == 0 :
			array[i] = min(array[i-1] + 1 , array[i//2] + 1)
		else :
			array[i] = array[i-1] + 1
	print(array[num])

if __name__ == "__main__" :
	num = int(input())
	dp(num)