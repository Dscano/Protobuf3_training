import enum.enum_example_pb2 as enum_pb2

enum_message  = enum_pb2.EnumMessage()

enum_message.id = 156
enum_message.day_of_the_week = enum_pb2.SUNDAY

print(enum_message)

with open ('simple.bin',"wb") as f: #wb because protobuf is binary
    bytesAsString = enum_message.SerializeToString()
    f.write(bytesAsString)

#read  a file
with open ('simple.bin',"rb") as f: #wb because protobuf is binary
    enum_message_read = enum_pb2.EnumMessage().FromString(f.read())
    print("Read from file "+ str(enum_message_read))