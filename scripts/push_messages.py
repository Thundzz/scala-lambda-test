import boto3
import time

sqs = boto3.client("sqs")

for i in range(1000000):
	sqs.send_message(
		QueueUrl = "https://sqs.eu-west-1.amazonaws.com/882825261070/test-yaya-benben",
		MessageBody=f"bonjourno {i}\n"
	)
	print(f"pushed message :) {i}")
	time.sleep(0.25)