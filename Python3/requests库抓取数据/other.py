import re

import requests


def get_urls():
    headers = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36"
    }
    # 发送请求
    response = requests.get("https://ssr1.scrape.center/", headers=headers)

    result = re.findall(
        'src="(https.*?)"', response.text
    )
    print(result)
    return result
