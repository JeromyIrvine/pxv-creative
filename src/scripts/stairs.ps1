$blockname = $Args[0]

$templatePath = ".\src\scripts\stairs"
$outputPath = ".\src\main\resources\assets\pxvblocks"

$bsStairs = "${outputPath}\blockstates\${blockname}_stairs.json"
$bmStairs = "${outputPath}\models\block\${blockname}_stairs.json"
$bmInner = "${outputPath}\models\block\${blockname}_stairs_inner.json"
$bmOuter = "${outputPath}\models\block\${blockname}_stairs_outer.json"
$imStairs = "${outputPath}\models\item\${blockname}_stairs.json"

# Copy template files into place
Copy-Item ${templatePath}\blockstates_stairs.json       $bsStairs
Copy-Item ${templatePath}\blockmodel_stairs.json        $bmStairs
Copy-Item ${templatePath}\blockmodel_stairs_inner.json  $bmInner
Copy-Item ${templatePath}\blockmodel_stairs_outer.json  $bmOuter
Copy-Item ${templatePath}\itemmodel_stairs.json         $imStairs

# Replace template text
(Get-Content $bsStairs).Replace("<BLOCKNAME>", $blockname)  | Set-Content $bsStairs
(Get-Content $bmStairs).Replace("<BLOCKNAME>", $blockname)  | Set-Content $bmStairs
(Get-Content $bmInner).Replace("<BLOCKNAME>", $blockname)   | Set-Content $bmInner
(Get-Content $bmOuter).Replace("<BLOCKNAME>", $blockname)   | Set-Content $bmOuter
(Get-Content $imStairs).Replace("<BLOCKNAME>", $blockname)  | Set-Content $imStairs
