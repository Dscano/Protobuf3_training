import complex.complex_pb2 as complex_pb2

complex_message = complex_pb2.ComplexMessage()

complex_message.one_dummy.id = 123
complex_message.one_dummy.name = "I am a dummy message"

print("Complex Message with one dummy",complex_message)

#Multiple dummy
first_multiple_dummy = complex_message.multiple_dummy.add()

first_multiple_dummy.id = 345
first_multiple_dummy.name = "I the first element"

print("Complex Message with multiple dummy",complex_message)

complex_message.multiple_dummy.add(id=456, name= "second element");

print("Complex Message with 2 multiple dummy",complex_message)