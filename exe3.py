def is_prime(number_checked):
    """
    Checks if the number is prime.
    :param number_checked: to check it.
    :return: True if the number is prime and False else.
    """
    for factor in range(2, int(number_checked ** 1/2)):
        if number_checked % factor == 0:
            return False
    return True


def primes(number):
    """
    Creates a list of prime numbers under the parameter - number,
    and returns it.
    :param number: to list above it.
    :return: list of prime numbers under the parameter - number.
    """
    prime_numbers = []
    [prime_numbers.append(checked) for checked in range(2, int(number-1)) if is_prime(checked)]
    return prime_numbers


def largest_prime_factor(number):
    """
    Finds the largest prime factor of the number.
    :param number: to find the largest prime factor from it.
    :return: the largest prime factor of the number.
    """
    prime_numbers = primes(number)
    largest = 0
    for prime in prime_numbers:
        if number % prime == 0:
            largest = prime
    return largest


if __name__ == '__main__':
    print(largest_prime_factor(600851475143))

