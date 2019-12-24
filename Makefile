# Source code directory.
DirSrc=src
# Documentation directory, when the doc is generated.
DirOut=./doc
# Window title.
WinTitle='CrazyIDE Java'
# Documentation title.
DocTitle=$(WinTitle)
# Header text on each generated page.
HeadTxt='<b>Java plateform</b><br />v1.0'
# Footer text on each generated page.
BottTxt='Copyright &copy; 2019 LeFan D\'Ost'
# Packages "list".
Pack=CIDEPack
# Grouping of the package "CIDEPack".
GrpPack="Package CrazyIDE" "$(Pack)"
# 
OverView="src/overview.html"

Compilo=javadoc
Options=-sourcepath $(DirSrc)	 \
		-overview $(OverView)	 \
		-d $(DirOut)			 \
		-subpackages $(Pack)	 \
		-use					 \
		-splitIndex				 \
		-windowtitle $(WinTitle) \
		-doctitle $(DocTitle)	 \
		-header $(HeadTxt)		 \
		-bottom $(BottTxt)		 \
		-J-Xmx180m

all:
	$(Compilo) $(Options)