import unittest
from src.problems.convert_to_type import convert_to_type


class TestConvertToType(unittest.TestCase):

    def test_convert_to_string(self):
        self.assertEqual(convert_to_type("string", 123), "123")
        self.assertEqual(convert_to_type("string", True), "True")
        self.assertEqual(convert_to_type("string", None), "None")

    def test_convert_to_number(self):
        self.assertEqual(convert_to_type("number", "123"), 123.0)
        with self.assertRaises(ValueError):
            convert_to_type("number", "abc")

    def test_convert_to_boolean(self):
        self.assertEqual(convert_to_type("boolean", "true"), True)
        self.assertEqual(convert_to_type("boolean", "false"), False)
        with self.assertRaises(ValueError):
            convert_to_type("boolean", "abc")

    def test_convert_to_array(self):
        self.assertEqual(convert_to_type("array", "[1, 2, 3]"), [1, 2, 3])
        self.assertEqual(convert_to_type("array", [1, 2, 3]), [1, 2, 3])
        with self.assertRaises(ValueError):
            convert_to_type("array", "not an array")

    def test_convert_to_object(self):
        self.assertEqual(convert_to_type("object", '{"key": "value"}'), {"key": "value"})
        self.assertEqual(convert_to_type("object", {"key": "value"}), {"key": "value"})
        with self.assertRaises(ValueError):
            convert_to_type("object", "not an object")

    def test_unsupported_data_type(self):
        with self.assertRaises(ValueError):
            convert_to_type("unsupported", "123")


if __name__ == "__main__":
    unittest.main()
