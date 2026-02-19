# Migration TODO (Repository Cleanup)

Goal: Keep only source and learning materials in Git, remove IDE/runtime noise, and make folders easy to understand.

## 1) Create target top-level folders
- [x] Create `courses/java`
- [x] Create `courses/web`
- [x] Create `projects`
- [x] Create `archive`

## 2) Move Java learning source
- [x] Move `Java/Workspace/Me_java2025/src` -> `courses/java/me_java2025/src`
- [x] Keep `Java/Workspace/.metadata` local only (already ignored)
- [x] Keep Eclipse project metadata local only (`.classpath`, `.project`, `.settings`)

## 3) Move web learning materials
- [x] Move `javascript` -> `courses/web/javascript`
- [x] Move `Einführung HtmlCss` -> `courses/web/htmlcss`

## 4) Separate real projects vs exercises
- [x] Review `courses/web/htmlcss/Project/*`
- [x] Move long-term project(s) to `projects/`
- [x] Move old/duplicate versions (for example `02ChinesischLernen` vs `08ChinesischLernen`) to `archive/`

## 5) Keep Git clean after migration
- [x] Run: `git status`
- [x] Confirm no `*.class`, `bin/`, `.metadata/` files are tracked
- [ ] Stage only intended source moves and docs

## Suggested move order (safe)
1. Move one area at a time (Java first, then web)
2. Commit each area separately
3. Verify run/build in IDE after each commit






