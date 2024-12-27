import unittest
from src.problems.exampleProblem import add_numbers


class TestExampleProblem(unittest.TestCase):
    def test_add_positive_numbers(self):
        self.assertEqual(add_numbers(2, 3), 5)
        self.assertEqual(add_numbers(10, 20), 30)

    def test_add_negative_numbers(self):
        self.assertEqual(add_numbers(-1, -1), -2)
        self.assertEqual(add_numbers(-5, -10), -15)

    def test_add_mixed_sign_numbers(self):
        self.assertEqual(add_numbers(-5, 5), 0)
        self.assertEqual(add_numbers(10, -20), -10)

    def test_add_zero(self):
        self.assertEqual(add_numbers(0, 0), 0)
        self.assertEqual(add_numbers(0, 5), 5)


if __name__ == "__main__":
    unittest.main()
