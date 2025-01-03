function errorHandler(data, dataType) {
  throw new Error(`Cannot convert "${data}" to ${dataType}.`)
}

const dataTypeConverter = (dataType, data) => {
  /*
  * let num = 123;
    let strNum = String(num); // Converts the number to the string "123"

    let bool = true;
    let strBool = String(bool); // Converts the boolean to the string "true"

    let obj = { key: "value" };
    let strObj = String(obj); // Converts the object to "[object Object]"
  * */

  switch (dataType) {
    case 'string': {
      return JSON.stringify(data);
    }
    case 'number': {
      const number = Number(data);

      if (isNaN(number)) {
        errorHandler(data, 'Number');
      }

      return number;
    }
    case 'boolean': {
      // we're only considering casting string versions of the boolean
      if( data === 'true') return true;
      if( data === 'false') return false;

      errorHandler(data, 'Boolean');
    }

    case 'array': {
      if( Array.isArray(data)) {
        return data;
      }

      try {
        const array = JSON.parse(data)
        if( Array.isArray(array)) {
          return array
        }
      } catch (e) {
        errorHandler(data, 'Array');
      }

      errorHandler(data, 'Array');
    }

    case 'object': {
      if(typeof data === 'object') {
        return data;
      }

      if( typeof data === 'string') {
        try {
          return JSON.parse(data);
        } catch (e) {
          errorHandler(data, 'Object');
        }
      }

      errorHandler(data, 'Object');
    }

    default: {
      throw new Error("Unsupported data type: unsupportedType");
    }
  }


};

module.exports = dataTypeConverter;