#무식하게 품
def calDate(e, s, m, answer = 1):
    if(e%15 == 0) : e = 0
    if(s%28 == 0) : s = 0
    if(m%19 == 0) : m = 0
    while 1:
        if(answer%15 == e) :
            if(answer%28 == s) :
                if(answer%19 == m) :
                    break
                else :
                    answer = answer + 1
            else :
                answer = answer + 1
        else :
            answer = answer + 1
    return answer

# #중국인 나머지정리
def chinaCal(e,s,m):
    answer = (6916*e+4845*s+4200*m)%7980
    if answer == 0 :
        answer = (e*s*m)
    else : 
        pass
    return answer



if __name__ == "__main__":
    e,s,m = input().split()
    answer = chinaCal(int(e),int(s),int(m))
    print(answer)


