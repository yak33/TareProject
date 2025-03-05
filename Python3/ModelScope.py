'''
Author: ZHANGCHAO
Date: 2025-03-04 09:28:41
LastEditors: ZHANGCHAO
LastEditTime: 2025-03-04 09:44:09
FilePath: \Python3\ModelScope.py
'''
from openai import OpenAI

model_id = 'unsloth/DeepSeek-R1-Distill-Qwen-1.5B-GGUF'

client = OpenAI(
    base_url='https://ms-fc-f9d0e3d9-2e45.api-inference.modelscope.cn/v1',
    api_key='c6fbab76-82a8-440f-9f7e-3ba36baa1f29'
)

response=client.chat.completions.create(
    model=model_id,
    messages=[{"role":"user", "content":"你是什么大模型？"}],
    stream=True
)

for chunk in response:
    print(chunk.choices[0].delta.content, end='', flush=True)