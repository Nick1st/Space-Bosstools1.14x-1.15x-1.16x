package net.mcreator.boss_tools.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.boss_tools.BossToolsModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@BossToolsModElements.ModElement.Tag
public class OxygenGeneratortickProcedure extends BossToolsModElements.ModElement {
	public OxygenGeneratortickProcedure(BossToolsModElements instance) {
		super(instance, 201);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure OxygenGeneratortick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure OxygenGeneratortick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure OxygenGeneratortick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure OxygenGeneratortick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double previousRecepie = 0;
		previousRecepie = (double) (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "recipe"));
		if ((((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Blocks.OAK_LEAVES, (int) (1)).getItem())
				&& ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == new ItemStack(Blocks.OAK_LEAVES, (int) (1))
						.getItem()) && ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) <= 1)) || ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) == 0)))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("recipe", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem())
				&& ((new Object() {
					public int getAmount(BlockPos pos, int sltid) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).getCount());
							});
						}
						return _retval.get();
					}
				}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) == 0))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("recipe", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Blocks.SPRUCE_LEAVES, (int) (1)).getItem())
				&& ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == new ItemStack(Blocks.SPRUCE_LEAVES, (int) (1))
						.getItem()) && ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) <= 1)) || ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) == 0)))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("recipe", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Blocks.BIRCH_LEAVES, (int) (1)).getItem())
				&& ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == new ItemStack(Blocks.BIRCH_LEAVES, (int) (1))
						.getItem()) && ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) <= 1)) || ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) == 0)))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("recipe", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Blocks.JUNGLE_LEAVES, (int) (1)).getItem())
				&& ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == new ItemStack(Blocks.JUNGLE_LEAVES, (int) (1))
						.getItem()) && ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) <= 1)) || ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) == 0)))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("recipe", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Blocks.ACACIA_LEAVES, (int) (1)).getItem())
				&& ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == new ItemStack(Blocks.ACACIA_LEAVES, (int) (1))
						.getItem()) && ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) <= 1)) || ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) == 0)))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("recipe", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Blocks.ACACIA_LEAVES, (int) (1)).getItem())
				&& ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == new ItemStack(Blocks.ACACIA_LEAVES, (int) (1))
						.getItem()) && ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) <= 1)) || ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) == 0)))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("recipe", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Blocks.DARK_OAK_LEAVES, (int) (1)).getItem())
				&& ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == new ItemStack(Blocks.DARK_OAK_LEAVES, (int) (1))
						.getItem()) && ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) <= 1)) || ((new Object() {
							public int getAmount(BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) == 0)))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("recipe", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
		if (((previousRecepie) != (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "recipe")))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("timer", 0);
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
		if (((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "recipe")) >= 0)) {
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "timer")) >= 400)) {
				if (((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "recipe")) == 0)) {
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
								"/effect clear @e[type=minecraft:player,distance=..7] boss_tools:damage_remove");
					}
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
								"/effect clear @e[type=minecraft:player,distance=..7] boss_tools:damage_remove_2");
					}
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
								"/effect clear @e[type=minecraft:player,distance=..7] boss_tools:damage_remove_3");
					}
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
								"/effect clear @e[type=minecraft:player,distance=..7] boss_tools:damage_remove_4");
					}
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
								"/effect clear @e[type=minecraft:player,distance=..7] boss_tools:bullet_generator");
					}
				} else if (((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "recipe")) == 1)) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _sltid = (int) (0);
							final int _amount = (int) 1;
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									ItemStack _stk = capability.getStackInSlot(_sltid).copy();
									_stk.shrink(_amount);
									((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
								}
							});
						}
					}
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("timer", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "fuel")) == 0)) {
				if ((((new Object() {
					public int getAmount(BlockPos pos, int sltid) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).getCount());
							});
						}
						return _retval.get();
					}
				}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) > 0) && ((new Object() {
					public int getAmount(BlockPos pos, int sltid) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).getCount());
							});
						}
						return _retval.get();
					}
				}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) != 0))) {
					if (((new Object() {
						public int getEnergyStored(BlockPos pos) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
							return _retval.get();
						}
					}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))) >= 1)) {
						if (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Blocks.OAK_LEAVES, (int) (1))
								.getItem())) {
							{
								TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
								if (_ent != null) {
									final int _sltid = (int) (0);
									final int _amount = (int) 1;
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											ItemStack _stk = capability.getStackInSlot(_sltid).copy();
											_stk.shrink(_amount);
											((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
										}
									});
								}
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("fuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("maxFuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						} else if (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Blocks.SPRUCE_LEAVES, (int) (1)).getItem())) {
							{
								TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
								if (_ent != null) {
									final int _sltid = (int) (0);
									final int _amount = (int) 1;
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											ItemStack _stk = capability.getStackInSlot(_sltid).copy();
											_stk.shrink(_amount);
											((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
										}
									});
								}
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("fuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("maxFuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						} else if (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Blocks.BIRCH_LEAVES, (int) (1))
								.getItem())) {
							{
								TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
								if (_ent != null) {
									final int _sltid = (int) (0);
									final int _amount = (int) 1;
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											ItemStack _stk = capability.getStackInSlot(_sltid).copy();
											_stk.shrink(_amount);
											((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
										}
									});
								}
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("fuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("maxFuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						} else if (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Blocks.JUNGLE_LEAVES, (int) (1)).getItem())) {
							{
								TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
								if (_ent != null) {
									final int _sltid = (int) (0);
									final int _amount = (int) 1;
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											ItemStack _stk = capability.getStackInSlot(_sltid).copy();
											_stk.shrink(_amount);
											((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
										}
									});
								}
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("fuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("maxFuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						} else if (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Blocks.ACACIA_LEAVES, (int) (1)).getItem())) {
							{
								TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
								if (_ent != null) {
									final int _sltid = (int) (0);
									final int _amount = (int) 1;
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											ItemStack _stk = capability.getStackInSlot(_sltid).copy();
											_stk.shrink(_amount);
											((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
										}
									});
								}
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("fuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("maxFuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						} else if (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Blocks.ACACIA_LEAVES, (int) (1)).getItem())) {
							{
								TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
								if (_ent != null) {
									final int _sltid = (int) (0);
									final int _amount = (int) 1;
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											ItemStack _stk = capability.getStackInSlot(_sltid).copy();
											_stk.shrink(_amount);
											((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
										}
									});
								}
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("fuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("maxFuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						} else if (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Blocks.DARK_OAK_LEAVES, (int) (1)).getItem())) {
							{
								TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
								if (_ent != null) {
									final int _sltid = (int) (0);
									final int _amount = (int) 1;
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											ItemStack _stk = capability.getStackInSlot(_sltid).copy();
											_stk.shrink(_amount);
											((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
										}
									});
								}
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("fuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("maxFuel", 400);
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						}
					}
				} else {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("timer", 0);
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			}
		}
		if (((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "fuel")) > 0)) {
			if (((new Object() {
				public int getEnergyStored(BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))) >= 1)) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("fuel", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "fuel")) - 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "recipe")) >= 0)) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("timer", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "timer")) + 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((new Object() {
					public int getEnergyStored(BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))) >= 1)) {
					if (((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "OxygenLarge")) == 0)) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							int _amount = (int) 1;
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/particle minecraft:cloud ~0.5 ~1 ~0.5 0.1 .1 0.1 .001 1 force");
						}
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/effect give @e[type=minecraft:player,distance=..4] boss_tools:damage_remove 1 1 true");
						}
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/effect give @e[type=minecraft:player,distance=..4] boss_tools:damage_remove_2 1 1 true");
						}
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/effect give @e[type=minecraft:player,distance=..4] boss_tools:damage_remove_3 1 1 true");
						}
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/effect give @e[type=minecraft:player,distance=..4] boss_tools:damage_remove_4 1 1 true");
						}
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/effect give @e[type=minecraft:player,distance=..4] boss_tools:bullet_generator 1 1 true");
						}
					}
					if (((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "OxygenLarge")) == 1)) {
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
							int _amount = (int) 1;
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/particle minecraft:cloud ~0.5 ~1 ~0.5 0.1 .1 0.1 .001 1 force");
						}
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/effect give @e[type=minecraft:player,distance=..7] boss_tools:damage_remove 1 1 true");
						}
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/effect give @e[type=minecraft:player,distance=..7] boss_tools:damage_remove_2 1 1 true");
						}
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/effect give @e[type=minecraft:player,distance=..7] boss_tools:damage_remove_3 1 1 true");
						}
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/effect give @e[type=minecraft:player,distance=..7] boss_tools:damage_remove_4 1 1 true");
						}
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/effect give @e[type=minecraft:player,distance=..7] boss_tools:bullet_generator 1 1 true");
						}
					}
				}
			}
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("fuelRemaining", (((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "fuel")) / (new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "maxFuel"))) * 100));
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("EnergyGui", (new Object() {
					public int getEnergyStored(BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))));
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("fire", (new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "fuel")));
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
	}
}
