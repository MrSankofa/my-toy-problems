import json


def error_handler(data, dataType):
    raise ValueError(f"Cannot convert '{data}' to {dataType}.")


def convert_to_type(dataType, data):
    # How to determine data type
    # Switch
    if dataType == "string":
        return str(data)
    elif dataType == "number":
        return float(data)
    elif dataType == "boolean":
        if data in [True, "true", "True"]:
            return True
        elif data in [False, "false", "False"]:
            return False
        error_handler(data, 'Boolean')
    elif dataType == "array":
        if isinstance(data, list):
            return data
        try:
            # investigate what this does
            # how to convert str array to array and Object
            return json.loads(data)
        except json.JSONDecodeError:
            error_handler(data, "Array")
    elif dataType == "object":
        if isinstance(data, dict):
            return data

        try:
            # how to convert str array to array and Object
            return json.loads(data)
        except json.JSONDecodeError:
            error_handler(data, "Object")
    else:
        raise ValueError(f"Unsupported data type: {dataType}")
