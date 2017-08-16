$blockname = $Args[0]

$templatePath = ".\src\scripts\trapdoor"
$outputPath = ".\src\main\resources\assets\pxvblocks"

$bsTrapDoor = "${outputPath}\blockstates\${blockname}_trapdoor.json"
$bmBottom = "${outputPath}\models\block\${blockname}_trapdoor_bottom.json"
$bmOpen = "${outputPath}\models\block\${blockname}_trapdoor_open.json"
$bmTop = "${outputPath}\models\block\${blockname}_trapdoor_top.json"
$imTrapDoor = "${outputPath}\models\item\${blockname}_trapdoor.json"

# Copy template files into place
Copy-Item ${templatePath}\blockstates_trapdoor.json         $bsTrapDoor
Copy-Item ${templatePath}\blockmodel_trapdoor_bottom.json   $bmBottom
Copy-Item ${templatePath}\blockmodel_trapdoor_open.json     $bmOpen
Copy-Item ${templatePath}\blockmodel_trapdoor_top.json      $bmTop
Copy-Item ${templatePath}\itemmodel_trapdoor.json           $imTrapDoor

# Replace template text
(Get-Content $bsTrapDoor).Replace("<BLOCKNAME>", $blockname)    | Set-Content $bsTrapDoor
(Get-Content $bmBottom).Replace("<BLOCKNAME>", $blockname)      | Set-Content $bmBottom
(Get-Content $bmOpen).Replace("<BLOCKNAME>", $blockname)        | Set-Content $bmOpen
(Get-Content $bmTop).Replace("<BLOCKNAME>", $blockname)         | Set-Content $bmTop
(Get-Content $imTrapDoor).Replace("<BLOCKNAME>", $blockname)    | Set-Content $imTrapDoor
