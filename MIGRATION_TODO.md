# Migration TODO (Repository Cleanup)

Goal: Keep only source and learning materials in Git, remove IDE/runtime noise, and make folders easy to understand.

## 1) Create target top-level folders
- [x] Create `courses/java`
- [ ] Create `courses/web`
- [ ] Create `projects`
- [ ] Create `archive`

## 2) Move Java learning source
- [x] Move `Java/Workspace/Me_java2025/src` -> `courses/java/me_java2025/src`
- [ ] Keep `Java/Workspace/.metadata` local only (already ignored)
- [ ] Keep Eclipse project metadata local only (`.classpath`, `.project`, `.settings`)

## 3) Move web learning materials
- [ ] Move `javascript` -> `courses/web/javascript`
- [ ] Move `Einführung HtmlCss` -> `courses/web/htmlcss`

## 4) Separate real projects vs exercises
- [ ] Review `courses/web/htmlcss/Project/*`
- [ ] Move long-term project(s) to `projects/`
- [ ] Move old/duplicate versions (for example `02ChinesischLernen` vs `08ChinesischLernen`) to `archive/`

## 5) Keep Git clean after migration
- [ ] Run: `git status`
- [ ] Confirm no `*.class`, `bin/`, `.metadata/` files are tracked
- [ ] Stage only intended source moves and docs

## Suggested move order (safe)
1. Move one area at a time (Java first, then web)
2. Commit each area separately
3. Verify run/build in IDE after each commit

