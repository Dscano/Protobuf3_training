import simple.simple_pb2 as simple_pb2

simple_message = simple_pb2.SimpleMessage()
#the various fields are declare by refelction, i.e no IDE tips
simple_message.id = 123
simple_message.is_simple = True
simple_message.name = "This is a simple message"

print(simple_message)

sample_list = simple_message.sample_list
sample_list.append(3)
sample_list.append(4)
sample_list.append(5)

#write a file
with open ('simple.bin',"wb") as f: #wb because protobuf is binary
    bytesAsString = simple_message.SerializeToString()
    f.write(bytesAsString)

#read  a file
with open ('simple.bin',"rb") as f: #wb because protobuf is binary
    simple_message_read = simple_pb2.SimpleMessage().FromString(f.read())
    print("Read from file "+ str(simple_message_read))

print("Is Simple?: " + str(simple_message.is_simple))
print("Id?: " + str(simple_message.id))