### <span id="top">分析过程</span>

参考本人  [blog](https://blog.csdn.net/weixin_38737912/article/details/105253563)

### 爬取思路 (供参考)

    APP列表可以查1000条,单法院单天几乎没有超过这个限制 (想想之前APP列表只有20条的时候😓)
    
    就是构建查询条件, 按照时间+ 法院进行查询
    
    法院列表参考 resources目录下 court.json (2019爬取,3525个法院, 不保证现在也全)
    
    具体请求参数,可以在APP里修改后再抓包

### 更新日志
- 2021/06/28 详情接口仍可用
- 2021/06/09 新版本APP加入用户校验,列表接口失效, 详情接口仍可用
- 2021/05/25 测试正常使用,升级gradle,kotlin版本
- 2021/04/15 测试正常使用,READ_ME显示美化
- 2021/04/09 测试正常使用
- 2021/03/01 测试正常使用
- 2021/01/25 测试正常使用
<details>
<summary>2020更新记录</summary>
<ul>
<li>2020/12/16 测试正常使用,加入查询条件,详情不公开理由</li>
<li>2020/11/11 测试正常使用,加入阿里云repo镜像,升级kotlin和gradle版本</li>
<li>2020/09/29 测试正常使用</li>
<li>2020/08/19 测试正常使用</li>
<li>2020/07/07 测试正常使用</li>
<li>2020/05/22 测试正常使用</li>
<li>2020/05/07 测试正常使用</li>
<li>2020/04/26 测试正常使用, 列表字段映射</li>
<li>2020/04/23 测试正常使用, 新增爬取思路,法院json</li>
<li>2020/04/20 测试正常使用</li>
<li>2020/04/17 测试 列表获取详情为空, App显示暂无数据 <a href="http://wenshu.court.gov.cn/MobilePage/mobile.html">文书网app 官方下载链接</a>   可自行测试</li>
</ul>
</details>

### LICENSE

```
Copyright 2021 Leon406

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```



## Stargazers over time

[![Stargazers over time](https://starchart.cc/Leon406/wenshukt.svg)](https://starchart.cc/Leon406/wenshukt)


[回到顶部](#top)

