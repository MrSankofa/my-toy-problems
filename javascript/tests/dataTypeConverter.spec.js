const convertToType = require('../src/dataTypeConverter');

describe('convertToType', () => {
  test('should convert data to string', () => {
    expect(convertToType('string', 123)).toBe('123');
    expect(convertToType('string', true)).toBe('true');
    expect(convertToType('string', null)).toBe('null');
    expect(convertToType('string', { make: "Toyota", model: "Supra"})).toBe("{\"make\":\"Toyota\",\"model\":\"Supra\"}");
  });

  test('should convert data to number', () => {
    expect(convertToType('number', '123')).toBe(123);
    expect(convertToType('number', 45.67)).toBe(45.67);
    expect(() => convertToType('number', 'abc')).toThrow(
      'Cannot convert "abc" to Number.'
    );

    expect(() => convertToType('number', { make: "Toyota", model: "Supra"})).toThrow(
      'Cannot convert \"[object Object]\" to Number.'
    );
  });

  test('should convert data to boolean', () => {
    expect(convertToType('boolean', 'true')).toBe(true);
    expect(convertToType('boolean', 'false')).toBe(false);
    expect(() => convertToType('boolean', 'abc')).toThrow(
      'Cannot convert "abc" to Boolean.'
    );
  });

  test('should convert data to array', () => {
    expect(convertToType('array', '[1,2,3]')).toEqual([1, 2, 3]);
    expect(convertToType('array', [1, 2, 3])).toEqual([1, 2, 3]);
    expect(() => convertToType('array', 'not an array')).toThrow(
      'Cannot convert "not an array" to Array.'
    );
  });

  test('should convert data to object', () => {
    expect(convertToType('object', '{"key":"value"}')).toEqual({
      key: 'value',
    });
    expect(convertToType('object', { key: 'value' })).toEqual({
      key: 'value',
    });
    expect(() => convertToType('object', 'not an object')).toThrow(
      'Cannot convert "not an object" to Object.'
    );
  });

  test('should throw error for unsupported data type', () => {
    expect(() => convertToType('unsupportedType', '123')).toThrow(
      'Unsupported data type: unsupportedType'
    );
  });
});
