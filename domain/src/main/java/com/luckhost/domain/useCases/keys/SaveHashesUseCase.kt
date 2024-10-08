package com.luckhost.domain.useCases.keys

import com.luckhost.domain.repository.NoteHashesRepoInterface

class SaveHashesUseCase(
    private val hashesRepository: NoteHashesRepoInterface,
) {
    fun execute(hashList: List<String>) {
        hashesRepository.saveHashes(hashList)
    }
}