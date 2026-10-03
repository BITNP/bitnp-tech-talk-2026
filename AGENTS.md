# 中文技术分享会幻灯片编写规范

本项目用于计算机与软件开发知识分享。你的任务是把用户提供的内容整理成准确、易讲、易读、能够编译的中文 Beamer 幻灯片。主题固定为 `pureminimalistic`，以仓库根目录的主题源码和 demo 为依据。

本文件放在仓库根目录，对根目录及所有分享子目录生效。子目录的补充规范负责该场分享的特殊要求；用户当前明确要求优先。不要把 demo 中的示例文字、作者、机构或注释中的个人偏好当作用户要求。

## 1. 先确认目录，再编辑

项目根目录当前为：

```text
/home/potato/Projects/bitnp-tech-talk-2026/
```

每场分享是仓库根目录下的**一个直接子目录**，入口 `.tex` 直接放在该子目录中，不再向下嵌套“分享/章节”两级目录。所有分享共用根目录的五个主题文件和 `talk-common.tex`。**从本场子目录编译，所以当前目录不是项目根目录，仓库根目录就是当前目录的上一层（`..`）。**

组织方式如下；标记“按需”的项目是建议结构，不代表已经存在：

```text
bitnp-tech-talk-2026/
├── AGENTS.md
├── LICENSE
├── beamerthemepureminimalistic.sty
├── beamercolorthemepureminimalistic.sty
├── beamerfontthemepureminimalistic.sty
├── beamerinnerthemepureminimalistic.sty
├── beamerouterthemepureminimalistic.sty
├── beamertheme-pure-minimalistic-demo.tex  # 上游示例，只作参考
├── talk-common.tex                      # 共享导言区，放在根目录
├── shared-assets/                       # 按需：实际共用的图片/logo
├── 01-overview/                         # 一场分享一个直接子目录
│   ├── main.tex                         # 本场入口，\input{../talk-common.tex}
│   ├── sections/                        # 按需：拆分的内容文件
│   ├── assets/                          # 按需：本场图片
│   ├── code/                            # 按需：本场代码示例
│   └── build/                           # 编译产物和检查用图片
└── 02-topic/                            # 示例名称，不要无故创建
    └── main.tex
```

- 先查看当前目录、现有文件和 Git 状态，确定用户要编辑哪场分享。已有入口文件名称优先，不要为了统一命名擅自改名。
- 每场分享只占根目录下的一个直接子目录，不要再嵌套层级；入口用 `\input{../talk-common.tex}` 相对引用根目录的共享导言区。
- 不将根目录的 `.sty` 复制到各子目录，不在子目录放置同名主题文件。所有分享必须使用同一份主题源码。
- 保留上游主题和 `LICENSE`。单场内容任务通常只改该场文件；主题定制放在共享导言区，避免直接修改上游 `.sty`。
- 如果需要统一中文字体、代码样式或配色，复用根目录的 `talk-common.tex`；它不存在时，在首次实际制作幻灯片时创建一次。先检查是否已有同等用途的配置，不重复建一套。
- 修改共享配置会影响多场分享，必须检查受影响的已有入口。不要覆盖用户未提交的内容，不自动提交、推送或重排其他分享。
- 文件使用 UTF-8、LF 换行。新素材文件名优先英文小写加连字符，如 `request-flow.pdf`。

## 2. 共用根目录主题的编译方式

**从本场入口 `.tex` 所在目录执行编译。** 本场目录是仓库根目录的直接子目录，`..` 即仓库根目录：

```bash
talk_root="$(git rev-parse --show-toplevel)"
test -f "$talk_root/beamerthemepureminimalistic.sty" || exit 1
mkdir -p build
TEXINPUTS=".:$talk_root:${TEXINPUTS:-}:" \
  latexmk -xelatex -interaction=nonstopmode -halt-on-error \
  -file-line-error -outdir=build main.tex
```

解释及限制：

- `talk_root` 必须指向含这五个 `.sty` 的仓库根目录。若目录不是 Git 仓库，沿父目录查找并确认主题文件，再设置根目录；不要盲猜 `..`。
- `TEXINPUTS` 同时加入本场目录和根目录，末尾的 `:` 保留 TeX 系统默认搜索路径。不要漏掉，也不要把根目录写死进每个 `.tex`。
- 共享导言区用 `\input{../talk-common.tex}` 相对引用，不依赖 `TEXINPUTS`；`TEXINPUTS` 的作用是让 `\usetheme{pureminimalistic}` 按包名找到根目录的五个 `.sty`。
- `\usetheme{pureminimalistic}` 会加载多个组件，仅给主主题写一个相对路径无法可靠解决组件查找。
- 不给根目录添加递归搜索 `//`，避免捡到其他分享中同名的内容文件。
- 需要核对加载来源时，使用同样的 `TEXINPUTS` 运行 `kpsewhich beamerthemepureminimalistic.sty`，返回值应该是本仓库根目录文件。
- 本场 `assets/`、`code/`、`sections/` 的路径统一相对于入口所在目录。即使代码写在 `sections/*.tex` 中，图片也写 `assets/...`，不是相对于该分节文件。
- 根目录共享素材可写成 `shared-assets/logo.pdf`，由上述搜索路径查找；不要引用别场分享的私有素材。编译时核实文件确实被找到。
- 从根目录运行时，先进入本场子目录（如 `01-overview`）再执行以上命令。不要直接在根目录编译 `01-overview/main.tex`，否则本场相对路径会改变。
- 默认 PDF 为本场 `build/main.pdf`。若入口名称不同，替换命令和输出文件名。不要把本场辅助文件写入项目根目录。
- 不默认启用 `-shell-escape`，也不安装依赖或改换引擎来掩盖源代码错误。

## 3. 中文与共享导言区

默认采用 **XeLaTeX + ctex + pureminimalistic**，16:9。字体首选中文 `Noto Sans CJK SC`、英文 `Fira Sans`、代码 `Fira Mono`。主题和字体配置只保留一份。

用户没有指定明暗模式时，新分享先使用浅色；已有分享保持原风格。demo 使用 `darkmode` 只是示例，不代表用户已经选定深色。

下面是创建 `talk-common.tex` 时可采用的基线。它不含 `\documentclass`、标题信息或 `document` 环境。已有共享配置时做最小修改，不反复覆盖：

```latex
% talk-common.tex — 放在仓库根目录
\usetheme[customfont,showmaxslides,nofooterlogo]{pureminimalistic}
\usefonttheme{professionalfonts}
\usepackage[UTF8,fontset=none]{ctex}
\usepackage{graphicx}
\usepackage{listings}
\usepackage{appendixnumberbeamer}

\setsansfont{Fira Sans}
\setmonofont{Fira Mono}
\setCJKmainfont{Noto Sans CJK SC}
\setCJKsansfont{Noto Sans CJK SC}
\setCJKmonofont{Noto Sans CJK SC}

% 默认不引用上游示例 logo
\renewcommand{\logotitle}{}
\renewcommand{\logoheader}{}
\renewcommand{\logofooter}{}
\renewcommand{\pageword}{}

% 设置必须在加载主题之后，避免被主题覆盖
\setbeamerfont{title}{size=\LARGE,shape=\upshape,series=\bfseries}
\setbeamerfont{presentation title}{shape=\upshape}
\setbeamerfont{frametitle}{size=\Large,shape=\upshape,series=\bfseries}

% 对浅色/深色都保持明确的代码对比度
\definecolor{TalkCodeBg}{HTML}{F3F4F6}
\definecolor{TalkCodeFg}{HTML}{17212B}
\definecolor{TalkCodeKeyword}{HTML}{174EA6}
\definecolor{TalkCodeComment}{HTML}{47634D}
\definecolor{TalkCodeString}{HTML}{8A3014}
\lstdefinestyle{talkcode}{
  basicstyle=\ttfamily\small\color{TalkCodeFg},
  backgroundcolor=\color{TalkCodeBg},
  keywordstyle=\bfseries\color{TalkCodeKeyword},
  commentstyle=\color{TalkCodeComment},
  stringstyle=\color{TalkCodeString},
  columns=fullflexible,
  keepspaces=true,
  showstringspaces=false,
  breaklines=true,
  tabsize=4,
  numbers=none,
  frame=none
}
\lstset{style=talkcode}
```

注意：

- 必须设置 `\setCJKsansfont`，因为 Beamer 正文默认使用无衬线字体；只设置 `\setCJKmainfont` 不够。
- 主题 `customfont` 选项让共享配置接管字体。不要再同时添加 `noto` 选项，主题的 Noto 选项也不等于自动配置中文。
- 保留 `\usefonttheme{professionalfonts}`，避免 Beamer 将 OpenType 正文字体误用于传统数学字体编码；公式仍使用现有数学字体，特殊数学字体另行统一配置。
- XeLaTeX 下不照搬 demo 的 `inputenc`，不再加载 `CJKutf8`，不混用多套中文方案。
- 用 `fc-match 'Noto Sans CJK SC'` 等检查字体，并核对返回的实际字体族；`fc-match` 成功退出也可能只是找到了替代字体。缺字体时报告具体名称，或使用已安装且经过验证的中文字体。
- 主题源码会重定义 `\normalsize` 等字号，因此不能只改 `\documentclass[14pt]` 就宣称字号已放大。统一字号或中文行距调整放在共享配置中，重新检查列表、标题、代码和页脚。
- `\setCJKmonofont` 不会自动解决 `listings` 的所有中文解析和对齐问题，代码中文另见第 6 节。

每场入口可采用下面的结构；填写真实元信息，未知作者、机构、日期不要编造：

```latex
\documentclass[aspectratio=169]{beamer}
\input{../talk-common.tex}

\title[软件如何运行]{从源代码到程序运行}
\author{分享者姓名}
\institute{}
\date{}

\begin{document}
\maketitle

\section{程序的执行过程}
\begin{frame}{源代码怎样变成运行中的程序}
  \begin{itemize}
    \item 编译器将源代码转换为目标代码。
    \item 链接器组合目标文件与所需的库。
    \item 操作系统装载可执行文件并创建进程。
  \end{itemize}
\end{frame}

\end{document}
```

## 4. 这个主题的特殊规则

1. **`\maketitle` 放在 `\begin{document}` 后、所有 `frame` 外。** 主题的 `\maketitle` 会自己创建封面 frame，不要再包一层。
2. 所有标题、作者、机构、日期等元信息放在 `\begin{document}` 前。为长标题提供简短的 `\title[短标题]{完整标题}`，必要时作者、字幕也使用短形式，避免页脚挤在一起。
3. 上游默认引用 `logos/header_logo`、`logos/institute_logo` 及深色版本。本项目不能假定这些文件存在。无用户 logo 时，清空三个 logo 命令；有实际素材时再统一配置。`nofooterlogo` 只处理页脚，不能替代封面和页眉 logo 的处理。
4. 清空页眉 logo 后，标题区域仍受主题布局宽度限制，不会自动变成通栏。标题尽量一行，必要时两行，不能用超长句挤占正文。
5. `vfilleditems` 适合整页只有少量独立要点的情况。含图、代码、两栏或密集内容时用普通 `itemize`，避免多个弹性间距争夺高度。
6. 颜色定制使用主题已有接口，并放在加载主题之后、`\begin{document}` 之前。不要逐页重写主题。切换深色后，检查强调色、链接、代码框和图片背景，不能只加 `darkmode` 就视为完成。
7. 不复制 demo 中的示例图片、演示水印、作者机构和参考文献。`demo_bib.bib` 不一定存在，只有本场确实需要正式文献管理时才配置 `biblatex` 和实际 `.bib`，并检查 Biber。
8. 若有附录，使用 `appendixnumberbeamer` 配合 `\appendix`，把备查代码和补充细节放到末尾。区分 frame 数和 PDF 页数，叠加显示会增加 PDF 页数。

## 5. 内容组织与页面设计

### 讲述结构

- 先根据用户材料写简短大纲，再落实为页面。已明确的需求直接执行；只在缺失信息会改变主题内容或受众难度时提问。
- 每页一个主要观点，标题明确说明本页讨论什么或要证明什么。先介绍问题和背景，再讲机制、例子和结论。
- 正文以简体中文为主；技术名词首次出现可给出英文或缩写，后续保持一致。API、命令、标识符保持原始大小写。
- 准确区分事实、类比、简化模型和个人建议。省略异常处理的代码要说明，不能把概念演示伪装成生产实现。
- 不编造实验结果、版本特性、图片来源或引用。版本敏感的技术结论核对官方资料；引用和图片来源保留可追溯链接。
- 演讲补充说明放在本场讲稿或备注中。不要把整段讲稿塞进幻灯片，也不要把必要解释全删掉只剩口号。

### 默认设计

- 延续主题的极简风格：统一背景、一个主要强调色、少量加粗，保留空白。用对齐和距离表达层次。
- 常用四类页面：标题加要点、左右两栏、单张大图、代码加简短解释。确有教学价值时可以扩展，不为装饰创造新布局。
- 要点一般 3–5 条，每条尽量 1–2 行；列表最多两层。少量平行要点可使用 `vfilleditems`。
- 内容超过容量时，依次考虑删去重复、改为更清楚的图示、拆页、移入附录。不要默认使用 `shrink`、`\tiny`、整页缩放或负 `\vspace`。
- 正文保持主题正常字号；代码一般使用 `\small`。页脚和来源可以更小，但解释、代码和图中关键标签不能缩到只能近距离阅读。
- 演示用关键句避免长段落。中英文之间保持一致的排版方式，让 `ctex` 处理间距，勿靠连续空格或手工 `\\` 对齐。
- 默认静态显示。逐步揭示只用于确实需要分步骤讲解的过程，并检查每一步的占位和页数。不要给每个列表无差别加 `\pause`。
- 同一组对比使用一致尺度、颜色语义和布局。对错或状态区别同时使用文字，不能仅靠红绿颜色。

## 6. LaTeX 与代码规范

- 优先使用标准 `frame`、`itemize`、`enumerate`、`block`、`columns`、`figure` 和 `\includegraphics`。不要引入复杂自定义 frame 包装器。
- 缩进统一为两个空格，环境成对闭合，每个 frame 前后留空行。注释解释教学目的或必要排版取舍，不逐行复述语法。
- 普通文本中的 `%`、`&`、`_`、`#`、`$` 等按 LaTeX 语法转义。代码环境保留原始字符，不额外转义。路径和 URL 使用合适的命令，不拼接未经处理的 LaTeX。
- 行内标识符用 `\texttt{...}`，注意其中下划线仍需转义。长路径、URL 不硬塞标题或页脚；使用简短链接标签。
- `\end{frame}` 独占一行，不在其后追加注释。包含 `lstlisting`、`verbatim` 或 `\verb` 的 frame 必须添加 `[fragile]`。本项目为统一处理，外部代码页也添加 `[fragile]`。
- 代码默认用共享 `listings` 样式，不另建一套高亮系统。不在 `block`、宏参数等位置嵌套逐字代码；直接放在 frame 或 column 中。
- 每页代码一般 10–15 行，尽量不超过 18 行，每行目标不超过约 70 个字符；双栏需要更短。自动折行仅作保护，应该主动选择更清楚的断行。
- 展示代码必须保留真实缩进和语义。省略的部分用语言合适的注释说明；不能为缩短代码悄悄改变行为。行号仅在讲解需要引用时启用。
- 较长或可运行示例放在本场 `code/` 中，用 `\lstinputlisting` 引用；必要时选择行范围，但同步检查实际文件行号。LaTeX 编译成功不能证明示例代码正确，声称可运行前应执行对应的必要验证。
- `listings` 只设置它实际支持的语言；不要臆造 `language=TypeScript` 等配置。遇到不支持的语言先使用无语言高亮的等宽代码，或采用已验证的语言定义。
- 新编写的示例可用英文注释并在代码外用中文讲解。用户已有中文字符串或注释时保留其含义，不能为解决排版擅自翻译或删除；先验证中文显示，必要时使用经过验证的 `fvextra` 逐字排版。不要宣称加 `inputencoding=utf8` 就解决了一切中文问题。
- 默认不引入 `minted`，避免增加外部高亮工具依赖；用户要求或已有项目使用它时沿用并记录实际编译条件。

代码页示例：

```latex
\begin{frame}[fragile]{函数返回值如何传回调用方}
  \begin{lstlisting}[language=Python]
def square(value):
    return value * value

result = square(4)
print(result)  # 16
  \end{lstlisting}
  \medskip
  \texttt{return} 把计算结果交回调用方。
\end{frame}
```

## 7. 图片、两栏、表格与图示

- 图片必须来自实际存在的文件。优先 PDF 矢量图、PNG 截图或 JPEG 照片；SVG 先转换成 PDF/PNG，不能直接假定 `\includegraphics` 支持。
- 同时限制最大宽度和高度并保留比例。栏内使用 `\linewidth`，不要误用整页 `\textwidth`。图片下方有说明时继续减少最大高度。
- 截图裁掉无关区域、保证文字清晰，不拉伸、不放大低分辨率图片。深色主题下检查白底图片是否突兀，优先统一图片呈现方式。
- 优先复用用户材料。示意图只用于帮助理解，区分示意图和真实截图。简单关系图可以使用简洁、可维护的 TikZ；复杂图优先外部生成后插入，不编写大段绝对坐标布局。
- 表格只展示有意义的比较，避免长段落单元格；一般控制在 3–4 列和少量行。超出容量就拆分，不能整表缩小到不可读。
- 不照搬论文浮动体设置如 `[H]`。Beamer 中明确安排图和说明，通常用 `\centering` 加 `\includegraphics` 即可。

两栏页示例，使用前必须替换为本场真实存在的图片：

```latex
\begin{frame}{请求经过哪些组件}
  \begin{columns}[T,onlytextwidth]
    \begin{column}{0.44\textwidth}
      \begin{itemize}
        \item 客户端发送请求。
        \item 服务端处理并返回响应。
      \end{itemize}
    \end{column}
    \begin{column}{0.52\textwidth}
      \centering
      \includegraphics[
        width=\linewidth,
        height=0.55\textheight,
        keepaspectratio
      ]{assets/request-flow.pdf}
    \end{column}
  \end{columns}
\end{frame}
```

## 8. 验证与交付

1. 先确认本场入口、共享配置和实际素材。新建时先编译封面、一页中文正文和一页代码，确保主题与字体路径正确，再扩展内容。
2. 按第 2 节在本场目录编译，读日志中的第一个真实错误并修复。不要只重复编译，也不要一次引入很多新包试错。
3. 检查缺字、字体替换、未定义引用、图片缺失和 `Overfull`。所有造成内容越界的警告必须处理；`Underfull` 结合视觉判断，不要仅为消除警告破坏排版。
4. 可用以下命令筛查日志。`rg` 无匹配时退出码为 1，不代表编译失败：

   ```bash
   rg -n 'Overfull|Underfull|Missing character|undefined|Warning|Error' build/main.log
   ```

5. 渲染并逐页检查 PDF，特别关注封面、最长标题、最密正文、两栏、代码、图片和页脚。可用：

   ```bash
   mkdir -p build/preview
   pdftoppm -scale-to 1600 -png build/main.pdf build/preview/slide
   ```

6. 检查中文是否缺字、代码缩进是否保留、字号是否适合投影、图中文字是否可读、页脚是否重叠、内容是否被裁掉。PDF 能打开不等于检查通过；没有视觉查看能力时明确说出未完成视觉检查。
7. 修改共享导言区或主题时，重新编译受影响的已有分享，重点查看布局可能改变的页面。只改某场内容时，不无故重建整个仓库。
8. 检查最终差异，只交付相关修改。辅助文件、预览 PNG 放在本场 `build/`，按项目约定忽略，不删除用户素材或其他场的成果。
9. 最终回复简要说明入口源文件、PDF 路径、实际执行的编译和视觉检查、仍存在的限制。未实际执行的检查不能声称完成。

## 9. 常见失败的处理顺序

| 现象 | 先检查什么 |
|---|---|
| 找不到主题或某个主题组件 | 当前工作目录、仓库根目录、`TEXINPUTS` 和末尾 `:`；不要复制 `.sty` 到子目录 |
| 找不到 `logos/...` | 三个 logo 命令是否清空或替换为真实路径 |
| 找不到本场图片/代码 | 是否从入口目录编译，路径是否相对于入口，文件大小写是否一致 |
| 中文空白、方框或字体报错 | XeLaTeX、`ctex`、实际安装字体、`\setCJKsansfont` |
| 代码页报错或编译一直读到文件末尾 | `[fragile]`、代码环境闭合、`\end{frame}` 是否独占一行 |
| 正文、代码或表格越界 | 先精简或拆页，再调整布局；不要先缩小字号 |
| 中文代码显示异常 | 区分字体问题与 `listings` 的字符处理问题，保留原内容再选择可靠排版方式 |
| 总页数或目录尚未更新 | 让 `latexmk` 完成必要重编译；区分 frame 数、附录和 overlay 页数 |
| 找不到参考文献或 Biber 失败 | 本场是否真的使用文献管理、实际 `.bib` 路径及 Biber 是否可用 |

依据：仓库根目录 `beamertheme-pure-minimalistic-demo.tex` 与五个 `.sty`；[主题多语言说明](https://github.com/kai-tub/latex-beamer-pure-minimalistic/tree/master/multi_lang_examples)；[OpenAI 官方 AGENTS.md 说明](https://developers.openai.com/codex/guides/agents-md/)。实际仓库代码和用户当前要求优先于外部示例。
