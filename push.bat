@echo off
::echo --����vuepress����
::npm run docs:build


echo --�ύ���زֿ�
git add .

set /p con=���������־��
git commit -m "%con%"

echo --Push��Զ�ֿ̲�
git push 

::echo --����Page
::start https://gitee.com/xxxgod/javadoc/pages

exit