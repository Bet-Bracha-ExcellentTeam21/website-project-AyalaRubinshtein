def sum_multiple(end_number):
    """
    Sums all the numbers divided by 3 or 5 below to the number end_number that obtained as a parameter.
    :param end_number: Border to sum.
    :return: sum below end_number.
    """
    return sum(filter(lambda number: number % 3 == 0 or number % 5 == 0, range(end_number)))


if __name__ == '__main__':
    print(sum_multiple(1000))
