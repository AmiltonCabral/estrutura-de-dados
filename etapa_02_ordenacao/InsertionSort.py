def sort(list):
    for i in range(1, len(list)):
        j = i
        while (j > 0 and list[j] < list[j-1]):
            #swap
            list[j], list[j-1] = list[j-1], list[j]
            j -= 1
    return list


# concatena duas listas
def catenate(lstA, lstB):
    for item in lstB:
        lstA.append(item)
    return lstA
    

assert sort([3,5,8,1,10,7]) == [1,3,5,7,8,10]
assert sort([1]) == [1]
assert sort([2,1]) == [1,2]
assert sort([1,2]) == [1,2]
assert sort([1,2,3,4,5,0]) == [0,1,2,3,4,5]
assert sort([5,4,3,2,1,6]) == [1,2,3,4,5,6]
assert sort([]) == []

assert catenate([1,2], [3,4]) == [1,2,3,4]
lstA = [1,2]
lstB = [6]
catenate(lstA, lstB)
assert lstA == [1,2,6]