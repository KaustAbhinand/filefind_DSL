# FILEFIND - A Custom DSL - Version 1.0

A custom Domain Specific Language (DSL) used to retrieve files on the computer.

## Overview

- Follows a simple, SQL-like syntax
- Search for files by extension, size, created date, and date modified
- Supports `recently` keyword — defaults to files from the last 15 days

## Sample Query

```sql
filefind "find file from 'C:\Users' where ext = pdf"
```

Retrieves all PDF files from the Users directory.

## Supported Conditions

- `ext` — file extension (e.g. `ext = "pdf"`)
- `size` — file size (e.g. `size > 10000MB`) (no spaces between number and units)
- `created` — creation date (e.g. `created = recently`)
- `date-modified` — last modified date (e.g. `date-modified < 30`)
- `name like` - search files by name
- `created = recently` - search files modified 15 days ago

## Operators
- All logical operators
- Boolean: `and`, `or`, `not`

## Installation command
- Navigate to powershell (no admin permission required)
- paste this command: `irm https://raw.githubusercontent.com/KaustAbhinand/filefind_DSL/main/install.ps1 | iex`
- run `filefind --help` to confirm the installation worked.

Check the sample_queries doc provided, you'll get a fair idea on the syntax :)
