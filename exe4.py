def is_palindrome(number):
    """
    checks whether a number is a palindrome.
    :param number: the checked.
    :return: True if it is palindrome and False else.
    """
    return str(number) == str(number)[::-1]


def main():
    """
    Finds the largest palindrome made from the product of two 3-digit numbers.
    and print it.
    """
    longest_palindrome = 0
    for factor_one in range(1000):
        for factor_two in range(1000):
            multiplied = factor_one * factor_two
            if is_palindrome(multiplied):

                if multiplied > longest_palindrome:
                    longest_palindrome = multiplied
                    factor_palindrome_one = factor_one
                    factor_palindrome_two = factor_two

    print(str(factor_palindrome_one) + "*" + str(factor_palindrome_two) + "=" + str(longest_palindrome))


if __name__ == '__main__':
    main()
