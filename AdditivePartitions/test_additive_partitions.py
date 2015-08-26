__author__ = 'user'

import unittest
from additive_partitions import additive_partitions

class MyTestCase(unittest.TestCase):
    def test_ap_one(self):
        self.assertEqual(additive_partitions(1), [[1]])

    def test_ap_two(self):
        self.assertEqual(additive_partitions(2), [[1, 1]])

    def test_ap_three(self):
        self.assertEqual(additive_partitions(3), [[1, 2], [1, 1, 1]])

    def test_ap_four(self):
        self.assertEqual(additive_partitions(4), [[1, 3], [1, 1, 2], [1, 1, 1, 1], [2, 2]])

    def test_ap_five(self):
        self.assertEqual(additive_partitions(5), [[1, 4], [1, 1, 3], [1, 1, 1, 2], [1, 1, 1, 1, 1], [1, 2, 2], [2, 3]])


if __name__ == '__main__':
    unittest.main()
