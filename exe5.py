def smallest_multiple(number):
    """
    Finds the smallest positive number that is evenly divisible
    by all of the numbers from 1 to number.
    :param number: to check above it.
    :return: smallest positive number that is evenly divisible
    by all of the numbers from 1 to number.
    """
    found_number = False
    smallest = 1
    while found_number != True:
        for factor in range(1, number+1):
            if smallest % factor != 0:
                break
        if factor == number:
            found_number = True
        else:
            smallest = smallest + 1

    return smallest


if __name__ == '__main__':
    print(smallest_multiple(20))
