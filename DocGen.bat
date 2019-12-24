@echo off

set DirSrc="src"
set DirOut="doc"
set WinTitle="CrazyIDE"
set DocTitle=%WinTitle%
set HeadTxt="<b>Java plateform</b><br />v1.0"
set BottTxt="Copyright &copy; 2019 LeFan D'Ost"
set Pack="CIDEPack"
set GrpPack="Package CrazyIDE" "%Pack%"
set OverView="src/overview.html"

set Compilo=javadoc
set Options=-sourcepath %DirSrc% -overview %OverView% -d %DirOut% -subpackages %Pack% -use -splitIndex -windowtitle %WinTitle% -doctitle %DocTitle% -header %HeadTxt% -bottom %BottTxt% -J-Xmx180m

rem @echo on

rem chcp 1252
chcp 65001

echo Doc generation values :
echo %DirSrc%
echo %DirOut%
echo %WinTitle%
echo %DocTitle%
echo %HeadTxt%
echo %BottTxt%
echo %Pack%
echo %GrpPack%
echo %OverView%
echo ************

echo List of source code directory :
dir /b /s %DirSrc%
echo ************

echo Beginning of generation...

@echo on

%Compilo% %Options%

@echo off

echo Documentation generated.