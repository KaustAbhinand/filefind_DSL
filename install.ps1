# install.ps1 - installs FileFind for the current user (no admin needed)
$ErrorActionPreference = "Stop"

$repo    = "KaustAbhinand/filefind"
$dir     = Join-Path $env:LOCALAPPDATA "Programs\FileFind"
$zipPath = Join-Path $env:TEMP "filefind.zip"
$extract = Join-Path $env:TEMP "filefind-extract"

Write-Host "==> Finding the latest release"
$release = Invoke-RestMethod "https://api.github.com/repos/$repo/releases/latest"
$asset   = $release.assets | Where-Object { $_.name -like "filefind-*-windows-x64.zip" } | Select-Object -First 1
if (-not $asset) { throw "No Windows zip found in the latest release." }

Write-Host "==> Downloading $($asset.name)"
Invoke-WebRequest $asset.browser_download_url -OutFile $zipPath

Write-Host "==> Installing to $dir"
if (Test-Path $dir) { Remove-Item -Recurse -Force $dir }
Expand-Archive $zipPath -DestinationPath $extract -Force
New-Item -ItemType Directory -Force $dir | Out-Null
Copy-Item -Recurse -Force "$extract\filefind\*" $dir
Remove-Item -Recurse -Force $zipPath, $extract

$p = [Environment]::GetEnvironmentVariable("Path", "User")
if (($p -split ";") -notcontains $dir) {
    [Environment]::SetEnvironmentVariable("Path", "$p;$dir", "User")
    Write-Host "Added to PATH. Open a new terminal."
}
Write-Host "==> Done. Run: filefind --help"