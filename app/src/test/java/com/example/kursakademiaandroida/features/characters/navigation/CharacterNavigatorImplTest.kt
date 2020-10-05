package com.example.kursakademiaandroida.features.characters.navigation

import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.navigation.FragmentNavigator
import com.example.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import com.example.kursakademiaandroida.features.episodes.navigation.EpisodeNavigator
import com.example.kursakademiaandroida.features.episodes.navigation.EpisodeNavigatorImpl
import com.example.kursakademiaandroida.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CharacterNavigatorImplTest {

    @Test
    fun `WHEN openCharacterDetailsScreen is called THAN invoke navigateTo method of FragmentNavigator with appropriate action and character model as arguments`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val character = CharacterDisplayable.mock()
        val slot = slot<Pair<String, CharacterDisplayable>>()

        //when
        characterNavigator.openCharacterDetailsScreen(character)

        //than
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_characters_screen_to_character_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe character
    }

    @Test
    fun `WHEN goBack is called THAN invoke goBack method of FragmentNavigator`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigatorImpl(fragmentNavigator)

        //when
        episodeNavigator.goBack()

        //than
        verify { fragmentNavigator.goBack() }

    }
}