def sum_even_fibonacci(end_number):
    """
    Sums the numbers in an even index in fibonacci.
    :param end_number: Border to sum.
    :return: sum of the numbers in an even index in fibonacci.
    """
    list_fibonacci = [1, 2]
    [list_fibonacci.append(list_fibonacci[index-1] + list_fibonacci[index-2]) for index in range(2, end_number+1)]
    return sum(list(filter(lambda value: list_fibonacci.index(value) % 2 == 0, list_fibonacci)))


if __name__ == '__main__':
    print(sum_even_fibonacci(4000000))


#And this is for you:), I did it first...
def sum_even_fibonacci_not_pythonic(end_number):
    """
    Sums the numbers in an even index in fibonacci.
    :param end_number: Border to sum.
    :return: sum of the numbers in an even index in fibonacci.
    """
    last_number = 2
    before_last = 1
    sum_even_numbers = 0
    count = 2

    while count <= end_number:
        if count % 2 == 0:
            sum_even_numbers = sum_even_numbers + last_number
        # Move to the next index
        last_number = last_number + before_last
        before_last = last_number - before_last
        count = count + 1
    return sum_even_numbers

