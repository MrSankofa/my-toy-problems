import unittest
from src.problems.SherlockHomesAnagrams import sherlock_homes_find_anagrams


class TestSherlockHolmes(unittest.TestCase):
    def test_abba(self):
        self.assertEqual(sherlock_homes_find_anagrams("abba"), 4)

    def test_abba(self):
        self.assertEqual(sherlock_homes_find_anagrams("abcd"), 0)

    def test_abba(self):
        self.assertEqual(sherlock_homes_find_anagrams("ifailuhkqq"), 3)

    def test_abba(self):
        self.assertEqual(sherlock_homes_find_anagrams("cdcd"), 5)

    def test_abba(self):
        self.assertEqual(sherlock_homes_find_anagrams("kkkk"), 10)

if __name__ == "__main__":
    unittest.main()