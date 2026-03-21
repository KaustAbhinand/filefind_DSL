# FILEFIND - A Custom DSL

A custom Domain Specific Language (DSL) used to retrieve files on the computer.

## Overview

- Follows a simple, SQL-like syntax
- Search for files by extension, size, created date, and date modified
- Supports `recently` keyword — defaults to files from the last 15 days

## Sample Query

```sql
find file from "C:\Users" where ext = "pdf"
```

Retrieves all PDF files from the Users directory.

## Supported Conditions

- `ext` — file extension (e.g. `ext = "pdf"`)
- `size` — file size in bytes (e.g. `size > 10000`)
- `created` — creation date (e.g. `created = recently`)
- `date-modified` — last modified date (e.g. `date-modified < 30`)

## Roadmap

- [ ] Mathematics in conditions
- [ ] Error messages
- [ ] Installer / JAR packaging
- [ ] Logical operators (and, or, nor)

---

More features coming soon! :)
