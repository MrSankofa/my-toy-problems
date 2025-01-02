import pytest
from src.problems.generate_substrings import generate_substrings


def test_generate_substrings_basic():
    input_str = "abc"
    expected = ["a", "ab", "abc", "b", "bc", "c"]
    result = generate_substrings(input_str)
    assert result == expected


def test_generate_substrings_empty_string():
    input_str = ""
    expected = []
    result = generate_substrings(input_str)
    assert result == expected


def test_generate_substrings_single_character():
    input_str = "a"
    expected = ["a"]
    result = generate_substrings(input_str)
    assert result == expected


def test_generate_substrings_duplicate_characters():
    input_str = "aa"
    expected = ["a", "aa", "a"]
    result = generate_substrings(input_str)
    assert result == expected


def test_generate_substrings_longer_string():
    input_str = "abcd"
    expected = ["a", "ab", "abc", "abcd", "b", "bc", "bcd", "c", "cd", "d"]
    result = generate_substrings(input_str)
    assert result == expected
