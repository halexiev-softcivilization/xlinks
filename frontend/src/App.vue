<script setup lang="ts">
import { ref } from 'vue'
const isConnecting = ref(false)
const connectX = () => { isConnecting.value = true; setTimeout(() => { isConnecting.value = false; window.location.href = '/dashboard' }, 1200) }
</script>
<template>
  <div class="min-h-screen bg-[#0a0a0a] text-white">
    <nav class="fixed top-0 w-full border-b border-white/10 bg-[#0a0a0a]/80 backdrop-blur-xl">
      <div class="max-w-7xl mx-auto px-6 h-16 flex items-center justify-between">
        <div class="flex items-center gap-3"><div class="w-9 h-9 rounded-xl bg-[#1d9bf0] flex items-center justify-center text-xl">🔗</div><div class="font-semibold text-xl">xlinks</div></div>
        <button @click="connectX" class="px-6 py-2 bg-[#1d9bf0] text-black rounded-2xl font-semibold">{{ isConnecting ? 'Connecting...' : 'Connect X Account' }}</button>
      </div>
    </nav>
    <div class="pt-24 text-center px-6">
      <h1 class="text-7xl font-semibold tracking-tighter mb-6">Your X bookmarks.<br><span class="text-[#1d9bf0]">Forever.</span></h1>
      <p class="max-w-2xl mx-auto text-2xl text-white/70 mb-10">Sync, archive full threads, download media, and view everything beautifully — even if originals disappear.</p>
      <button @click="connectX" class="px-10 py-4 bg-white text-black rounded-2xl text-lg font-semibold">Connect your X account →</button>
    </div>
  </div>
</template>