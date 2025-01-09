import unittest

from src.problems.bubble_sort import log_swaps


class TestLogSwaps(unittest.TestCase):
    def test_0_swaps(self):
        self.assertEqual(log_swaps([1, 2, 3]), f"""
      Array is sorted in 0 swaps.
      First Element: 1
      Last Element: 3
    """)

    def test_reverse_order_swaps(self):
        self.assertEqual(log_swaps([3, 2, 1]), f"""
      Array is sorted in 3 swaps.
      First Element: 1
      Last Element: 3
    """)

    def test_negative_numbers_swaps(self):
        self.assertEqual(log_swaps([3, 2, 1, -1, -3, -5]), f"""
      Array is sorted in 15 swaps.
      First Element: -5
      Last Element: 3
    """)