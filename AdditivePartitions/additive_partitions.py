#!/usr/bin/env python.

"""Module for calculating the additive partitions of a given number.
"""

__author__ = 'Jeremy Ebneyamin'

base_cases = {1: [[1]],
              2: [[1, 1]]}


def additive_partitions(number):
    partitions = []

    if number == 1 or number == 2:
        return base_cases.get(number)

    for x in range(1, number // 2 + 1):
        partitions.append([x, (number - x)])

        sub_list_x = additive_partitions(x)
        sub_list_c = additive_partitions(number - x)

        sub_partitions_list = [sub_x + sub_c for sub_x in sub_list_x for sub_c in sub_list_c]

        for element in sub_partitions_list:
            element.sort()

        partitions.extend([element for element in sub_partitions_list if element not in partitions])

    return partitions
