$pwd=Get-Location
$vpp_path="$(Get-Location)\scripts\kttkpm.vpp"
$out_path="$(Get-Location)\out\vpp"
mkdir $out_path
cd 'C:\Program Files\Visual Paradigm CE 17.1\scripts'
.\ExportXML.bat -project $vpp_path -out $out_path -noimage
cd $pwd