import time
import unittest
from src.problems.max_toys import max_toys;


class TestMaxToys(unittest.TestCase):

    def test_find_3_toys(self):
        self.assertEqual(max_toys([1, 2, 3, 4], 7), 3)

    def test_large_input(self):
        sample_size = 1000000
        sample_list = [1 for x in range(1, sample_size + 1)]

        start_time = time.time()

        result = max_toys(sample_list, sample_size)

        end_time = time.time()

        duration = end_time - start_time

        print(f"Execution time: {duration}  ms")

        self.assertEqual(result, sample_size)
        self.assertTrue(duration < 100)
