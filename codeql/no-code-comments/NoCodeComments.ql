// SPDX-FileCopyrightText: 2026 Xquik contributors
// SPDX-License-Identifier: Apache-2.0

/**
 * @name Code comment
 * @description Code has no comments. A comment needs a legal marker, a functional directive, an https link that proves it, or it documents the public API.
 * @kind problem
 * @problem.severity error
 * @id java/no-code-comments
 */

import java

predicate proven(KtComment comment) {
  comment.getText().regexpMatch("(?s).*(https://|SPDX-|REUSE-Ignore).*")
  or
  exists(KtComment next |
    next.getFile() = comment.getFile() and
    next.getLocation().getStartLine() = comment.getLocation().getEndLine() + 1 and
    proven(next)
  )
}

predicate directive(KtComment comment) {
  comment.getText().regexpMatch("(?s)//\\s*(ktfmt:|language=|noinspection|@formatter:).*")
}

predicate publicDeclaration(Modifiable declaration) {
  (declaration.isPublic() or declaration.isProtected()) and
  not declaration.isInternal() and
  not declaration.getFile().getRelativePath().regexpMatch(".*/internal/.*") and
  declaration.getFile().getRelativePath().regexpMatch(".*/src/main/.*")
}

predicate documentsEnumEntry(KtComment comment) {
  not exists(comment.getOwner()) and
  exists(EnumType enum |
    publicDeclaration(enum) and
    enum.getFile() = comment.getFile() and
    enum.getLocation().getStartLine() < comment.getLocation().getStartLine() and
    enum.getLocation().getEndLine() > comment.getLocation().getEndLine()
  )
}

predicate documentsPublicApi(KtComment comment) {
  comment.isDocComment() and
  (publicDeclaration(comment.getOwner()) or documentsEnumEntry(comment))
}

predicate extractionArtifact(KtComment comment) { comment.getText().regexpMatch("PsiComment\\(\\w+\\)") }

from KtComment comment
where
  not extractionArtifact(comment) and
  not comment.getFile().getRelativePath().regexpMatch("(.*/)?build/.*") and
  not proven(comment) and
  not directive(comment) and
  not documentsPublicApi(comment)
select comment, "Code has no comments. Put the meaning in names, types and tests."
